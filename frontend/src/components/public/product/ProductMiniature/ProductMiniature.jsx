import { useEffect, useState } from "react";
import { api_path } from "../../../../util/apipath";
import { useNavigate } from "react-router-dom";
import { Spinner } from "../../Spinner/Spinner";
import { Tag } from "../../Tag/Tag";

import "./ProductMiniature.css";

export function ProductMiniature({ product }) {
    const [image, setImage] = useState();
    const url = api_path(product.imagen);
    const navigate = useNavigate();

    const fetchImage = async () => {
        const res = await fetch(url);
        const blob = await res.blob();
        setTimeout(() => {
            setImage(URL.createObjectURL(blob));
        }, Math.floor(Math.random() * 2000))
    }

    useEffect(() => {
        fetchImage();
    }, []);

    let classes = ["product-miniature"];

    if (product.stock == 0) {
        classes.push("no-stock")
    } else if (product.stock <= product.criticalStock) {
        classes.push("critical-stock");
    }

    return <div className={classes.join(' ')} onClick={(e) => {
        if (product.stock == 0 || e.target.closest("a")) return;
        navigate(`/productos/${product.id}`)
    }}>
        {
            image ? <ProductMiniContent product={product} image={image} /> : <Spinner />
        }
    </div>
}

function ProductMiniContent({ product, image }) {
    return <div className="content">
        <img src={image} />
        <h1 className="name">{product.nombre}</h1>
        <p className="price">{`$${product.precio}`}</p>
        <Tag href={`/productos?tipo=${product.tipoProducto.id}`} text={product.tipoProducto.nombre} />
    </div>
}

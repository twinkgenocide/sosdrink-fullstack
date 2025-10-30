import { useEffect, useState } from "react";
import { useSearchParams } from "react-router-dom";
import { api_path } from "../../../util/apipath";
import { Spinner } from "../../../components/public/Spinner/Spinner";
import "./ProductCatalog.css"
import { ProductMiniature } from "../../../components/public/product/ProductMiniature/ProductMiniature";

export function ProductCatalogPage() {
    const [searchParams] = useSearchParams();
    const [tipo, setTipo] = useState(searchParams.get('tipo') || null);

    useEffect(() => {
        setTipo(searchParams.get('tipo') || null)
    }, [searchParams])

    return <ProductCatalog tipo={tipo} />
}

export function ProductCatalog({ tipo, scroll, skip, texto }) {
    const [productos, setProductos] = useState([]);
    const [textoDefault, setTextoDefault] = useState('Nuestros productos');

    useEffect(() => {
        setProductos([]);
        const url = api_path('api/productos');
        const fetchData = async () => {
            const response = await fetch(url);
            if (response.ok) {
                const data = await response.json();
                setTimeout(() => {
                    const productos = tipo ? data.filter((p) => p.tipoProducto.id == tipo) : data;
                    setProductos(productos);
                    if (tipo && productos.length > 0) {
                        const nombreTipo = productos[0].tipoProducto.nombre;
                        setTextoDefault(`Productos de ${nombreTipo}`);
                    }
                }, 2000);
            }
        }
        fetchData();
    }, [tipo]);

    return <div className={scroll ? "product-catalog vertical" : "product-catalog"}>
        {productos.length > 0 ? <div className="products">
            <h1 className="title">{texto ? texto : textoDefault}</h1>
            <ProductList products={productos} />
        </div> : <Spinner />}
    </div>
}

export function ProductList({ products }) {
    return <>
        {products.map(product => <ProductMiniature key={product.id} product={product} />)}
    </>
}

import { useEffect, useState } from "react";
import { api_path } from "../../../../util/apipath"
import "./BlogMiniature.css"

export function BlogMiniature({ blog }) {
    const [image, setImage] = useState();
    const url = api_path(blog.imagenUrl);

    useEffect(() => {
        const getImage = async () => {
            // finish body
        }
    }, []);

    return <div className="blog-miniature">
        <img src={api_path(blog.imagenUrl)} />
        <h4>{blog.titulo}</h4>
    </div>
}

import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import { api_path } from "../../../util/apipath";
import { Disclaimer } from "../../../components/public/Disclaimer/Disclaimer";
import { Spinner } from "../../../components/public/Spinner/Spinner";
import { Tag } from "../../../components/public/Tag/Tag";
import "./Blog.css"
import Markdown from "react-markdown";

export function Blog() {
    const params = useParams();
    let [blog, setBlog] = useState(null);
    let [error, setError] = useState(null);

    const url = api_path(`api/blogs/${params.blogId}`);

    useEffect(() => {
        const fetchData = async () => {
            const response = await fetch(url);
            if (response.ok) {
                const data = await response.json();
                setTimeout(() => { setBlog(data) }, 2000)
            } else {
                setError(response.status);
            }
        };

        fetchData();
    }, []);

    if (error) {
        return <></>
    }

    return (
        <div className="blog-container">
            {blog ? (
                <BlogDisplay blog={blog} />
            ) : (
                <Spinner />
            )}
        </div>
    )

}

function BlogDisplay({ blog }) {
    return <>
        <article className="blog">
            <img src={api_path(blog.imagenUrl)} />
            <header className="blog-header">
                <h1>{blog.titulo}</h1>
                <h3>{blog.resumen}</h3>
                <div className="blog-header-horizontal">
                    <time dateTime={blog.fecha}>{new Date(blog.fecha).toLocaleString('es-CL', {
                        year: 'numeric',
                        month: 'long',
                        day: 'numeric'
                    })}</time>
                    <Tag href={`/blogs?categoria=${blog.categoriaBlog.id}`} text={blog.categoriaBlog.nombre} />
                </div>
            </header>
            <hr />
            <section className="blog-content">
                <Markdown>{blog.contenido}</Markdown>
                <Disclaimer />
            </section>
        </article>
    </>
}


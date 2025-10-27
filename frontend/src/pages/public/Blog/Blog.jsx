import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import { Disclaimer } from "../../../components/public/Disclaimer/Disclaimer";
import { Spinner } from "../../../components/public/Spinner/Spinner";
import "./Blog.css"
import Markdown from "react-markdown";

const api_path = (subpath) => `${window.location.protocol}//${window.location.hostname}:8080/${subpath}`

function BlogDisplay({ blog }) {
    return <>
        <article className="blog">
            <img src={api_path(blog.imagenUrl)} />
            <header className="blog-header">
                <h1>{blog.titulo}</h1>
                <h3>{blog.resumen}</h3>
            </header>
            <hr />
            <section className="blog-content">
                <Markdown>{blog.contenido}</Markdown>
                <Disclaimer />
            </section>
        </article>
    </>
}

export function Blog() {
    const params = useParams();
    let [blog, setBlog] = useState(null)
    let [error, setError] = useState(null)

    const url = `${window.location.protocol}//${window.location.hostname}:8080/api/blogs/${params.blogId}`

    useEffect(() => {
        const fetchData = async () => {
            const response = await fetch(url);
            if (response.ok) {
                const data = await response.json();
                setTimeout(() => { setBlog(data) }, 1000)
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

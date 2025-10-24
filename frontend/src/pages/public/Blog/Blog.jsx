import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import { Disclaimer } from "../../../components/public/Disclaimer/Disclaimer";
import { Spinner } from "../../../components/public/Spinner/Spinner";
import "./Blog.css"

function BlogDisplay(props) {
    return <>
        <article className="blog">
            <img src="https://talentclick.com/wp-content/uploads/2021/08/placeholder-image.png" />
            <header className="blog-header">
                <h1>{props.title}</h1>
                <h3>{props.summary}</h3>
            </header>
            <hr />
            <section className="blog-content">
                <p>{props.content}</p>
                <Disclaimer />
            </section>
        </article>
    </>
}

export function Blog() {
    const params = useParams();
    let [blog, setBlog] = useState(null)
    let [error, setError] = useState(null)

    const url = `https://jsonplaceholder.typicode.com/posts/${params.blogId}`;

    useEffect(() => {
        const fetchData = async () => {
            const response = await fetch(url);
            if (response.ok) {
                const data = await response.json();
                setTimeout(() => { setBlog(data) }, 3000)
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
                <BlogDisplay title={blog.title} summary="lol" content={blog.body} />
            ) : (
                <Spinner />
            )}
        </div>
    )

}

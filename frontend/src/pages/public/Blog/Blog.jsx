import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import { Disclaimer } from "../../../components/public/Disclaimer/Disclaimer";
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
    let params = useParams();
    let [blog, setBlog] = useState(null)
    let [error, setError] = useState(null)

    const url = `https://jsonplaceholder.typicode.com/posts/${params.blogId}`;

    useEffect(() => {
        const fetchData = async () => {
            const response = await fetch(url);
            if (response.ok) {
                const data = await response.json();
                setBlog(data);
            } else {
                setError(response.status);
            }
        };

        fetchData();
    }, []);

    if (error) {
        return <>
            <p>{error}</p>
        </>
    }
    else if (blog) {
        return <>
            <BlogDisplay title={blog.title} summary="lol" content={blog.body} />
        </>
    } else {
        return <>
            <p>hold on gro</p>
        </>
    }
}

import { useEffect, useState } from "react";
import { useSearchParams } from "react-router-dom";
import { api_path } from "../../../util/apipath";
import { Spinner } from "../../../components/public/Spinner/Spinner";
import { BlogMiniature } from "../../../components/public/blog/BlogMiniature/BlogMiniature";
import "./BlogCatalog.css"

export function BlogCatalog() {
    const [searchParams] = useSearchParams();
    const [blogs, setBlogs] = useState([]);

    useEffect(() => {
        setBlogs([]);
        const cat = searchParams.get("categoria")
        const url = api_path(cat ? `api/blogs?categoria=${cat}` : 'api/blogs');
        const fetchData = async () => {
            const response = await fetch(url);
            if (response.ok) {
                const data = await response.json();
                setTimeout(() => { setBlogs(data) }, 2000)
            }
        }
        fetchData();
    }, [searchParams]);

    return (
        <div className="blog-catalog">
            {blogs.length > 0 ? <BlogList blogs={blogs} /> : <Spinner />}
        </div>
    )
}

function BlogList({ blogs }) {
    const content = blogs.map(blog => {
        return <BlogMiniature key={blog.id} blog={blog} />
    })

    return <>{content}</>
}

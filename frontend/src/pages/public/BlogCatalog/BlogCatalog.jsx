import { useEffect, useState } from "react";
import { useSearchParams } from "react-router-dom";
import { api_path } from "../../../util/apipath";
import { Spinner } from "../../../components/public/Spinner/Spinner";
import { BlogMiniature } from "../../../components/public/blog/BlogMiniature/BlogMiniature";
import "./BlogCatalog.css"

export function BlogCatalog() {
    const [searchParams] = useSearchParams();
    const [blogs, setBlogs] = useState([]);

    const cat = searchParams.get("categoria")
    let url = cat ? `api/blogs?categoria=${cat}` : 'api/blogs';
    url = api_path(url);

    useEffect(() => {
        const fetchData = async () => {
            const response = await fetch(url);
            if (response.ok) {
                const data = await response.json();
                setTimeout(() => { setBlogs(data) }, 2000)
            }
        }
        fetchData();
    }, []);

    return (
        <div className="blog-catalog">
            {blogs ? <BlogList blogs={blogs} /> : <Spinner />}
        </div>
    )
}

function BlogList({ blogs }) {
    const content = blogs.map(blog => {
        return <BlogMiniature blog={blog} />
    })

    return <>{content}</>
}

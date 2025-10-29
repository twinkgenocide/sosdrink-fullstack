import { Link } from 'react-router-dom'
import './Tag.css'

export function Tag({ href, text }) {
    return <>
        <Link className='tag' to={href} rel="tag">{text}</Link >
    </>
}

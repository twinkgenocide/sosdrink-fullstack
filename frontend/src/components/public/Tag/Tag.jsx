import './Tag.css'

export function Tag({ href, text }) {
    return <>
        <a className='tag' href={href} rel="tag">{text}</a >
    </>
}

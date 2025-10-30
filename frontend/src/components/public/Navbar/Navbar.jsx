import { Link } from "react-router-dom";
import "./Navbar.css"

export function Navbar() {
    return <>
        <nav className="navbar">
            <div>
                <Link className="sosdrink-logo" to="/">
                    <p>SOSDRINK</p>
                </Link>
                <hr />
                <ul className="navbar-links">
                    <li><Link to="/productos">Productos</Link></li>
                    <li><Link to="/blogs">Blogs</Link></li>
                    <li><Link to="/nosotros">Nosotros</Link></li>
                    <li><Link to="/contacto">Contacto</Link></li>
                    <li><Link to="/login">Ingresa</Link></li>
                </ul>
                <hr />
            </div>
        </nav>
    </>
}

import { Link } from "react-router-dom"
import "./navsaludo.css"

export function NavbarAdmin() {

    return <>
        <div className="sidebar">
            <div>
                <div className="logo">
                    <span style={{ fontSize: "1.5em" }}></span>
                    <span>SOS Drink Administrador</span>
                </div>
                <nav>
                    <ul>
                        <li><Link to="/admin">🏠 Home</Link></li>
                        <li><Link to="/admin/usuarios">👥 Usuarios</Link></li>
                        <li><Link to="/admin/productos">🛒 Productos</Link></li>
                    </ul>
                </nav>
            </div>

        </div >
    </>



}

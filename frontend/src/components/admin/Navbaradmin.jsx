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
                        <li><a href="index.html">🏠 Home</a></li>
                        <li><a href="users.html">👥 Usuarios</a></li>
                        <li><a href="products.html">🛒 Productos</a></li>
                    </ul>
                </nav>
            </div>

        </div >
    </>



}

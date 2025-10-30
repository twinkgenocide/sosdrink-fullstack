import { useNavigate } from "react-router-dom";
import { api_path } from "../../../util/apipath";

import "./Login.css"

export function LoginPage() {
    const navigate = useNavigate();

    const onButtonSubmit = (e) => {
        e.preventDefault();
        const form = document.getElementById('login');
        if (form.checkValidity()) {
            const data = Object.fromEntries(new FormData(form).entries());
            const sendRequest = async () => {
                const response = await fetch(api_path('api/usuarios/login'), {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify(data)
                })

                if (response.ok) {
                    const data = await response.json();
                    if (data.tipoUsuario.nombre == 'administrador') {
                        navigate('/admin');
                    } else {
                        navigate('/productos')
                    }
                } else {
                    alert('Usuario o contraseña incorrecta!');
                }
            }
            sendRequest();
        } else {
            form.reportValidity();
        }
    }

    return <div className="login-container">
        <img src={api_path('api/img/nuevoSaborEnergetico2025.jpg')} />
        <form id="login">
            <h1>Bienvenid@ de vuelta!</h1>
            <label htmlFor="correo">Correo:</label>
            <input type="email" id="correo" name="correo" required />
            <br />
            <label htmlFor="clave">Clave:</label>
            <input type="password" id="clave" name="clave" required />
            <br />
            <button type="submit" className="neon-btn" onClick={onButtonSubmit}>INICIAR SESION</button>
        </form>
    </div>
}

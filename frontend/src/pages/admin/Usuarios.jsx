import { useEffect, useState } from "react"
import "./Usuarios.css"
import { useNavigate } from "react-router-dom";
import { api_path } from "../../util/apipath";

export function AdminUsers() {
  const [usuarios, setUsuarios] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    setUsuarios([]);
    const url = api_path('api/usuarios');
    const fetchData = async () => {
      const response = await fetch(url);
      if (response.ok) {
        const data = await response.json();
        setUsuarios(data);
      }
    }
    fetchData();
  }, []);

  return <>
    <div className="main-content">
      <div className="admin-header">
        <h1>USUARIOS</h1>
      </div>
      <div className="usuarios-panel">
        <div className="usuarios-header">
          <h3>Lista de usuarios</h3>
          <button className="btn-nuevo-usuario">Crear nuevo usuario</button>
        </div>
        <div className="usuarios-lista">
          <table>
            <thead>
              <tr>
                <th>Nombre</th>
                <th>Correo</th>
                <th>Rol</th>
              </tr>
            </thead>
            <tbody>
              {
                usuarios.map((p) => <tr onClick={() => navigate(`/admin/usuarios/${p.run}`)}>
                  <td>{p.nombre}</td>
                  <td>{p.correo}</td>
                  <td>{p.tipoUsuario.nombre}</td>
                </tr>
                )
              }
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </>
}

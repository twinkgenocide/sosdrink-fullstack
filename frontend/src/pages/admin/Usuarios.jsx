import React from 'react'

export function AdminUsers(){

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
              <tr>
                <td>Juan Pérez</td>
                <td>juanperez@email.com</td>
                <td>Administrador</td>
              </tr>
              <tr>
                <td>María López</td>
                <td>marialopez@email.com</td>
                <td>Usuario</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </>
}

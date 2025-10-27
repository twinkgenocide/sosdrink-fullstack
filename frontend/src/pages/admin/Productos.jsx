import React from 'react'

export function AdminProductos(){
  return <>
    <div class="main-content">
        <div class="admin-header">
            <h1>PRODUCTOS</h1>
        </div>
        <div class="productos-panel">
            <div class="productos-header">
                <h3>Lista de productos</h3>
                <button class="btn-nuevo-producto">Crear nuevo producto</button>
            </div>
            <div class="productos-lista">
                <table id="productos-tabla">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Precio</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
  </>
}


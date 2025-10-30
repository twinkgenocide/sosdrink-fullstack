import { useEffect, useState } from 'react'
import "./Productos.css"
import { api_path } from '../../util/apipath';
import { useNavigate } from 'react-router-dom';

export function AdminProductos() {
    const [productos, setProductos] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        setProductos([]);
        const url = api_path('api/productos');
        const fetchData = async () => {
            const response = await fetch(url);
            if (response.ok) {
                const data = await response.json();
                setProductos(data);
            }
        }
        fetchData();
    }, []);

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
                            {
                                productos.map((p) => <tr onClick={() => navigate(`/admin/productos/${p.id}`)}>
                                    <td>{p.id}</td>
                                    <td>{p.nombre}</td>
                                    <td>{`$${p.precio}`}</td>
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


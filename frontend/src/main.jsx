import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import { LayoutPublic } from './layouts/LayoutPublic';
import { Blog } from './pages/public/Blog/Blog';
import { BlogCatalogPage } from './pages/public/BlogCatalog/BlogCatalog';
import { LayoutAdmin } from './layouts/LayoutAdmin';
import { Saludo } from './components/admin/Saludo';
import { ProductCatalogPage } from './pages/public/ProductCatalog/ProductCatalog';
import { Product } from './pages/public/Product/Product';

import './index.css'
import { AdminUsers } from './pages/admin/Usuarios';
import { AdminProductos } from './pages/admin/Productos';

const router = createBrowserRouter([
  {
    path: '/',
    element: <LayoutPublic />,
    children: [
      {
        path: 'blogs',
        element: <BlogCatalogPage />
      },
      {
        path: 'blogs/:blogId',
        element: <Blog />
      },
      {
        path: 'productos',
        element: <ProductCatalogPage />
      },
      {
        path: 'productos/:productoId',
        element: <Product />
      }
    ]
  },
  {
    path: '/admin',
    element: <LayoutAdmin />,
    children: [
      {
        path: '/admin',
        index: true,
        element: <Saludo />
      },
      {
        path: '/admin/usuarios',
        element: <AdminUsers />
      },
      {
        path: '/admin/productos',
        element: <AdminProductos />
      }
    ]
  }
])

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <RouterProvider router={router} />
  </StrictMode>,
)

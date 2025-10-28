import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import { LayoutPublic } from './layouts/LayoutPublic';
import { Blog } from './pages/public/Blog/Blog';
import { LayoutAdmin } from './layouts/LayoutAdmin';
import { Saludo } from './components/admin/Saludo';

import './index.css'

const router = createBrowserRouter([
  {
    path: '/',
    element: <LayoutPublic />,
    children: [
      {
        path: '/blogs/:blogId',
        element: <Blog />
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
      }
    ]
  }
])

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <RouterProvider router={router} />
  </StrictMode>,
)

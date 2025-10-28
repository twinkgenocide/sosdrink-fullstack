import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import { LayoutPublic } from './layouts/LayoutPublic';
import './index.css'
import { Blog } from './pages/public/Blog/Blog';
import { BlogCatalog } from './pages/public/BlogCatalog/BlogCatalog';

const router = createBrowserRouter([
  {
    path: '/',
    element: <LayoutPublic />,
    children: [
      {
        path: 'blogs',
        element: <BlogCatalog />
      },
      {
        path: '/blogs/:blogId',
        element: <Blog />
      }
    ]
  }
])

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <RouterProvider router={router} />
  </StrictMode>,
)

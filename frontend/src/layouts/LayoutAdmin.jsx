import { Outlet } from "react-router-dom"
import { NavbarAdmin } from "../components/admin/Navbaradmin.jsx"

import "./LayoutAdmin.css"

export function LayoutAdmin() {
  return <>
    <div className="layout">
      <NavbarAdmin />
      <main>
        <Outlet />
      </main>
    </div>
  </>
}

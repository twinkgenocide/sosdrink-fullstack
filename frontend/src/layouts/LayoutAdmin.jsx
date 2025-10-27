import { Outlet } from "react-router-dom"
import { Saludo } from "../components/admin/Saludo.jsx"
import { Navbaradmin } from "../components/admin/Navbaradmin.jsx"

import ""

export function LayoutAdmin() {
  return <>
    <div className="layout">
      <Navbaradmin />
      <main>
        <Outlet />
      </main>
      <Saludo />
    </div>
  </>
}

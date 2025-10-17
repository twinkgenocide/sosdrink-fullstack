import { Outlet } from "react-router-dom"
import { Navbar } from "../components/public/Navbar/Navbar.jsx"
import { Footer } from "../components/public/Footer/Footer.jsx"
import "./LayoutPublic.css"

export function LayoutPublic() {
  return <>
    <div className="layout">
      <Navbar />
      <main>
        <Outlet />
      </main>
      <Footer />
    </div>
  </>
}

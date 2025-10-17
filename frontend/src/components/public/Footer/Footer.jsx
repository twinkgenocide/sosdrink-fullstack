import logoFacebook from "./icons/facebook-48.png"
import logoInstagram from "./icons/instagram-48.png"
import logoTwitter from "./icons/twitter-48.png"

import "./Footer.css"

export function Footer() {
    return <>
        <footer className="footer">
            <div>
                <ul className="contact-info">
                    <li><h2>Contacto</h2></li>
                    <li>+56 9 98563472</li>
                    <li>sosdrink@gmail.com</li>
                </ul>
                <ul className="social-media">
                    <li>
                        <a href="#">
                            <img src={logoFacebook} />
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src={logoInstagram} />
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src={logoTwitter} />
                        </a>
                    </li>
                </ul>
            </div>
        </footer>
    </>
}

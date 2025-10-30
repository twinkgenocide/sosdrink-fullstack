import "./Buttons.css"

export function NeonButton({ negative, onClick, children }) {
    return <button className={negative ? "neon-btn negative" : "neon-btn"} onClick={onClick}>{children}</button>
}

import "./Spinner.css"

export function Spinner() {
    return <>
        <div className="spinner-container">
            <div className="spinner">
                <div className="spinner-dot" />
                <div className="spinner-dot" />
                <div className="spinner-dot" />
            </div>
        </div>
    </>
}

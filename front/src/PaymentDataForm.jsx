import { useState } from "react";
import "./PaymentDataForm.css";

function PaymentDataForm() {
    const [name, setName] = useState("");
    const [surname, setSurname] = useState("");
    const [phone, setPhone] = useState("");
    const [selectedFaculty, setSelectedFaculty] = useState("");
    const [faculties, setFaculties] = useState(['ETF', 'TF', 'PMF', 'AA']);

    function handleSubmit(event) {
        event.preventDefault();
        const data = { name, surname, phone, selectedFaculty };
        fetch('http://localhost:8000/blogs/', {
            method: 'POST',
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(data)
        }).then(() => {
            console.log('new blog added');
            console.log(JSON.stringify(data));
        })
        console.log(data);
    }

    function handleFacultySelection(event) {
        setSelectedFaculty(event.target.value);
    }
    return (
        <form className="form-container" onSubmit={handleSubmit}>
            <label className="form-label">Ime:</label>
            <input
                className="form-input"
                type="text"
                value={name}
                onChange={(e) => setName(e.target.value)}
            />
            <label className="form-label">Prezime:</label>
            <input
                className="form-input"
                type="text"
                value={surname}
                onChange={(e) => setSurname(e.target.value)}
            />

            <label className="form-label">Telefon:</label>
            <input
                className="form-input"
                type="text"
                value={phone}
                onChange={(e) => setPhone(e.target.value)}
            />

            <label className="form-label">Fakultet:</label>
            <select className="form-select" value={selectedFaculty} onChange={handleFacultySelection}>
                {faculties.map((faculty) => (
                    <option key={faculty} value={faculty}>
                        {faculty}
                    </option>
                ))}
            </select>
            <button className="form-submit" type="submit">
                Nastavi
            </button>
        </form>

    );
}

export default PaymentDataForm;

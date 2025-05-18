import React, { useState } from 'react';
import axios from 'axios';
import './CustomerForm.css';

const CustomerForm = ({ onSuccess }) => {
    const [name, setName] = useState('');
    const [dateOfBirth, setDateOfBirth] = useState('');
    const [nicNumber, setNicNumber] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/customers', {
                name,
                dateOfBirth,
                nicNumber,
            });
            alert('Customer added successfully!');
            onSuccess();
            setName('');
            setDateOfBirth('');
            setNicNumber('');
        } catch (error) {
            alert('Error adding customer: ' + error.message);
        }
    };

    return (
        <div className="customer-form">
            <h2>Add Customer</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="Name"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    required
                />
                <input
                    type="date"
                    placeholder="Date of Birth"
                    value={dateOfBirth}
                    onChange={(e) => setDateOfBirth(e.target.value)}
                    required
                />
                <input
                    type="text"
                    placeholder="NIC Number"
                    value={nicNumber}
                    onChange={(e) => setNicNumber(e.target.value)}
                    required
                />
                <button type="submit">Add Customer</button>
            </form>
        </div>
    );
};

export default CustomerForm;

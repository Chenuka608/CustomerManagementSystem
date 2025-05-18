import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './CustomerList.css';

const CustomerList = () => {
    const [customers, setCustomers] = useState([]);

    useEffect(() => {
        const fetchCustomers = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/customers');
                setCustomers(response.data);
            } catch (error) {
                console.error('Error fetching customers:', error.message);
            }
        };

        fetchCustomers();
    }, []);

    return (
        <div className="customer-list">
            <h2>Customer List</h2>
            <table>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Date of Birth</th>
                    <th>NIC Number</th>
                </tr>
                </thead>
                <tbody>
                {customers.map((customer) => (
                    <tr key={customer.nicNumber}>
                        <td>{customer.name}</td>
                        <td>{customer.dateOfBirth}</td>
                        <td>{customer.nicNumber}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default CustomerList;

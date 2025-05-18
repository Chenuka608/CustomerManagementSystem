// src/components/NavBar.jsx
import React from 'react';
import { Link } from 'react-router-dom';
import './NavBar.css';

const NavBar = () => {
    return (
        <nav className="navbar">
            <ul>
                <li><Link to="/">Customer List</Link></li>
                <li><Link to="/add-customer">Add Customer</Link></li>
                <li><Link to="/bulk-upload">Bulk Upload</Link></li>
            </ul>
        </nav>
    );
};

export default NavBar;

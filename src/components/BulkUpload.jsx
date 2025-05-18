import React, { useState } from 'react';
import axios from 'axios';
import './BulkUpload.css';

const BulkUpload = () => {
    const [file, setFile] = useState(null);
    const [message, setMessage] = useState('');

    const handleFileChange = (event) => {
        setFile(event.target.files[0]);
    };

    const handleUpload = async (event) => {
        event.preventDefault();
        if (!file) {
            setMessage('Please select a file.');
            return;
        }

        const formData = new FormData();
        formData.append('file', file);

        try {
            const response = await axios.post('http://localhost:8080/api/bulk-upload/customers', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data',
                },
            });
            setMessage(response.data);
        } catch (error) {
            setMessage('Upload failed. ' + error.message);
        }
    };

    return (
        <div className="bulk-upload-container">
            <h2>Bulk Upload Customers</h2>
            <form onSubmit={handleUpload}>
                <input type="file" onChange={handleFileChange} />
                <button type="submit">Upload</button>
            </form>
            {message && <p className="message">{message}</p>}
        </div>
    );
};

export default BulkUpload;

import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Tooltip from "./Tooltip"; // Assuming Tooltip component is defined in './Tooltip'

const ConvertDateComponent = () => {
    const [date, setDate] = useState(''); // State for input date
    const [tooltipText, setTooltipText] = useState(''); // State for tooltip text
    const [currentDate, setCurrentDate] = useState(''); // State for current date

    // Effect to fetch tooltip data when component mounts or currentDate changes
    useEffect(() => {
        // Function to format date as 'YYYY-MM-DD'
        const formatDate = (date) => {
            const year = date.getFullYear();
            const month = String(date.getMonth() + 1).padStart(2, '0'); // January is 0
            const day = String(date.getDate()).padStart(2, '0');
            return `${year}-${month}-${day}`;
        };

        // Fetch tooltip data function
        const fetchTooltipData = async () => {
            try {
                const response = await axios.post('http://localhost:8000/api/send', {
                    date: currentDate // Use currentDate state here
                });
                setTooltipText(response.data); // Assuming response.data contains the tooltip text
            } catch (error) {
                console.error('Error fetching tooltip data:', error);
                setTooltipText('Error fetching tooltip data');
            }
        };

        // Fetch tooltip data when currentDate changes
        if (currentDate) {
            fetchTooltipData();
        }
    }, [currentDate]); // Run effect whenever currentDate changes

    // Function to handle date input change
    const handleDateChange = (e) => {
        setDate(e.target.value); // Update date state
        setCurrentDate(e.target.value); // Update currentDate state
    };

    // Function to format date as 'YYYY-MM-DD'
    const formatDate = (date) => {
        const year = date.getFullYear();
        const month = String(date.getMonth() + 1).padStart(2, '0'); // January is 0
        const day = String(date.getDate()).padStart(2, '0');
        return `${year}-${month}-${day}`;
    };

    // Get current date and update currentDate state on component mount
    useEffect(() => {
        const today = new Date();
        const formattedDate = formatDate(today);
        setCurrentDate(formattedDate); // Update currentDate state with formatted date
    }, []); // Run effect only on component mount

    return (
        <div>
            <h1>Convert Gregorian To Hijri</h1>

            {/* Input for date (if needed) */}
            {/* <p>Edit date:</p>
            <input
                type="text"
                value={date}
                onChange={handleDateChange}
                data-tip // Add this attribute for Tooltip
            /> */}

            {/* Display current date with Tooltip */}
            <Tooltip text={tooltipText}>
                <h1>Date: {currentDate}</h1>
            </Tooltip>
        </div>
    );
};

export default ConvertDateComponent;

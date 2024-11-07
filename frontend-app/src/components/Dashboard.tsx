import React, { useEffect, useState } from 'react';

const Dashboard: React.FC = () => {
    const [data, setData] = useState<any[]>([]);

    useEffect(() => {
        fetch('/api/fetch')
            .then(response => response.json())
            .then(data => setData(data))
            .catch(error => console.error("Error fetching data:", error));
    }, []);

    return (
        <div>
            <h1>Trending Financial Insights</h1>
            <ul>
                {data.map((item, index) => (
                    <li key={index}>{item}</li>
                ))}
            </ul>
        </div>
    );
};

export default Dashboard;

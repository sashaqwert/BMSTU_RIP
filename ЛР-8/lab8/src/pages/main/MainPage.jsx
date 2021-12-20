import React from 'react';

const MainPage = () => {
    return (
        <div>
            <div className='flex container mt-5'>
                <img
                    src='pic.jpg'
                    style={{'height':'100%','max-height':'100%', 'width':'100%', 'max-width':'50%'}}
                    alt='Фото 2-х животных'/>
            </div>
        </div>
    );
};

export default MainPage;
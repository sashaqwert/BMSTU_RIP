import React, {useEffect, useState} from 'react';
import {useParams} from "react-router";
import {getFromServer} from "../../utils/getFromServer";

const AnimalDetail = () => {
    const id = useParams().id;

    const [oper, setOper] = useState();
    const [isLoaded, setIsLoaded] = useState(false);
    useEffect(() => {
        getFromServer('http://127.0.0.1:8000/animals/' + id.toString()).then((data) => {
            setOper(data);
            setIsLoaded(true);
        });
    }, []);

    return (
        <div className="d-flex justify-content-center m-5">
            <table style={{'border': '2px solid black'}}>
                <tr>
                    <td>Вид:</td>
                    <td>{isLoaded ? oper.animal_type : 'загружается...'}</td>
                </tr>
                <tr>
                    <td style={{'padding':'10px'}}>Кличка:</td>
                    <td>{isLoaded ? oper.animal_name : 'загружается...'}</td>
                </tr>
                <tr>
                    <td>Фото:</td>
                    <td>{isLoaded ? <img src={oper.animal_photo} alt="Ошибка" width="99%"/> : 'загружается...'}</td>
                </tr>
            </table>
        </div>
    );
};

export default AnimalDetail;
import React from 'react';
import {Card} from 'react-bootstrap'
import {Link} from "react-router-dom";

const AnimalCard = ({id, animal_name, animal_type}) => {

    return (
        <Card className="card">
            <Card.Body>
                <div className="textStyle">
                    <Card.Title>{animal_name}</Card.Title>
                </div>
                <div className="textStyle">
                    <Card.Text>{animal_type}</Card.Text>
                </div>
                <Link to={'/animal/'+id.toString()}>Подробнее</Link>
            </Card.Body>
        </Card>
    );
};

export default AnimalCard;
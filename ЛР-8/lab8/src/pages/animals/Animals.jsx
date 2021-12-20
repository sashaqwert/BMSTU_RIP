import React, {useState} from 'react';
import {Button, Row, Col} from "react-bootstrap";
import AnimalCard from "../../components/card/AnimalCard";
import useWindowSize from "../../utils/useWindowSize";
import {getFromServer} from "../../utils/getFromServer";

const Animals = () => {

    const [opers, setOpers] = useState([]);

    const loadOpers = async () => {
        const results = await getFromServer('http://127.0.0.1:8000/animals/');
        await setOpers(results);
        document.getElementById("loadButton").hidden = true;
    }

    const {width} = useWindowSize();
    const isMobile = width && width <= 600;

    return (
        <div className="d-flex flex-column container justify-content-center">
            <div className="m-5" id="loadButton">
                <Button onClick={loadOpers}>Загрузить список животных</Button>
            </div>
            <div className="mb-5">
                <Row xs={1} md={isMobile ? 1 : 3} className="g-3">
                    {opers.map((item, index) => {
                        return <Col>
                            <AnimalCard {...item} key={index}/>
                        </Col>
                    })}
                </Row>
            </div>
        </div>
    );
};

export default Animals;
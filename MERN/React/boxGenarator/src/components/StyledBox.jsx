import Recat from 'react';
import styled from 'styled-components';

const StyledBox = styled.div`
border: 1px solid lightgray;
background: ${props => props.backgroundColor};
width: ${props => props.width +'px'};
height: ${props => props.height+'px'};
`;

export default StyledBox;
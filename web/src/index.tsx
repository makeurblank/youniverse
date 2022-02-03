import * as ReactDOM from 'react-dom';
import Button from '@mui/material/Button';

import App from './App';
import Youniverse  from './Youniverse';


const container = document.getElementById('app');
const container_youniverse = document.getElementById('youniverse');
const container_google_login = document.querySelector('#app');

ReactDOM.render(<App />, container);
ReactDOM.render(<Youniverse />, container_youniverse);
ReactDOM.render(<App />, container_google_login);


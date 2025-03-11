import { Route, Routes } from 'react-router-dom';
import Main from './pages/Main'
import Menu from './pages/Menu'
import NotFound from './pages/NotFound'
import './App.css';

function App() {
  return (
    <div id='app'>
      <Routes>
        <Route path='/' element={<Main />} /> 
        <Route path='/menu' element={<Menu />} />

        {/* 와일드 카드 : 스위치문의 default 같은 것 */}
        <Route path="*" element={<NotFound />} />
      </Routes>
    </div>
  );
}

export default App;

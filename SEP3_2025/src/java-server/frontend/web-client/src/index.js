import React from 'react';
import { createRoot } from 'react-dom/client';

function App(){
  const [products, setProducts] = React.useState([]);

  React.useEffect(()=>{
    fetch('/api/products').then(r=>r.json()).then(setProducts).catch(()=>{});
  },[]);

  return (<div style={{padding:20}}>
    <h1>Online Shop (Demo)</h1>
    <ul>
      {products.map(p=>(<li key={p.id}>{p.name} — ${p.price}</li>))}
    </ul>
  </div>);
}

const root = createRoot(document.getElementById('root'));
root.render(<App/>);

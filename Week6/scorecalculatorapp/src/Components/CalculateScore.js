import '../Stylesheets/mystyle.css';

const percentToDecimal = (decimal) => {
  return (decimal * 100).toFixed(2) + '%';
};

const calcScore = (total, goal) => {
  return percentToDecimal(total / goal);
};

export const CalculateScore = ({ Name, School, total, goal }) => {
  return (
    <div className="formatstyle">
      <h1 style={{ color: 'brown' }}>Student Details:</h1>

      <div className="Name">
        <b><span>Name:</span></b> <span style={{ fontWeight: 300, color: 'blue' }}>{Name}</span>
      </div>

      <div className="School">
        <b><span>School:</span></b> <span style={{ color: 'crimson' }}>{School}</span>
      </div>

      <div className="Total">
        <b><span>Total:</span></b> <span style={{ color: 'darkmagenta' }}>{total}</span> <span>Marks</span>
      </div>

      <div className="Score">
        <b>Score: </b> <span style={{ color: 'forestgreen' }}>{calcScore(total, goal)}</span>
      </div>
    </div>
  );
};

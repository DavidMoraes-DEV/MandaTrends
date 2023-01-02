import { Trend } from "../../../types/trend";

type Props = {
  trend: Trend;
};

const FeaturedTrend = ({ trend }: Props) => {
  return (
    <li>
      <a target="_blank" rel="noopener" href={trend.sourceUrl}>
        <figure className={trend.imgsUrl.length === 2 ? "home-featured-trends-images": ""}>
          {trend.imgsUrl.map((imgUrl) => (
            <img src={imgUrl.imgUrl} alt={trend.mainSubject} key={imgUrl.id}/>
          ))}
        </figure>
        <h1>{trend.title}</h1>
      </a>
      <p>
        {trend.description}
      </p>
      <span>
        <p>Fonte: {trend.source}</p>
      </span>
      <div className="featured-trends-card-time">
        <div className="featured-trends-time"></div>
      </div>
    </li>
  );
};

export default FeaturedTrend;

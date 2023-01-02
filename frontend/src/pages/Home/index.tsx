import { useEffect, useState } from "react";
import { SpringPage } from "../../types/spring";
import { Trend } from "../../types/trend";
import { requestBackend } from "../../util/requests";
import { AxiosRequestConfig } from "axios";
import "./styles.css";
import FeaturedTrend from "./FeaturedTrend";
import SecondaryTrend from "./SecondaryTrend";

const Home = () => {
  const [page, setPage] = useState<SpringPage<Trend>>();

  useEffect(() => {
    const config: AxiosRequestConfig = {
      method: "GET",
      url: "/trends",
      params: {
        page: 0,
        size: 10,
      },
    };

    requestBackend(config).then((response) => {
      setPage(response.data);
    });
  }, []);

  return (
    <main className="home-main-container" id="trends">
      <section className="home-featured-trends">
        <ul>
          {page &&
            page.content.map((trend) => {
              if (trend.id <= 2) {
                return <FeaturedTrend trend={trend} key={trend.id} />;
              }
            })}
        </ul>
      </section>

      <div className="row home-trends-container">
        <section className="col-6 home-trends">
          <ul>
            {page &&
              page.content.map((trend) => {
                if (trend.id > 2 && trend.id < 7) {
                  return <SecondaryTrend trend={trend} key={trend.id} />;
                }
              })}
          </ul>
        </section>
        <section className="col-6 home-trends">
          <ul>
            {page &&
              page.content.map((trend) => {
                if (trend.id > 6 && trend.id <= 10) {
                  return <SecondaryTrend trend={trend} key={trend.id} />;
                }
              })}
          </ul>
        </section>
      </div>
    </main>
  );
};

export default Home;

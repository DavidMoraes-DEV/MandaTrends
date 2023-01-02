import { useEffect, useState } from "react";
import { AxiosRequestConfig } from "axios";
import { SpringPage } from "../../types/spring";
import { Trend } from "../../types/trend";
import "./styles.css";
import { requestBackend } from "../../util/requests";

const Navbar = () => {
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
    <header className="home-header-container">
      <section className="home-header-content">
        <div className="home-header-figures">
          <img
            className="figure-circle"
            src="https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/header/circle.png"
            alt="circle"
          />
          <img
            className="figure-manda-trends"
            src="https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/header/manda_trends.png"
            alt="manda-trends-logo"
          />
          <div>
            <img
              className="figure-arrows"
              src="https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/header/arrows.png"
              alt="arrows"
            />
            <img
              className="figure-triangle"
              src="https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/header/triangle.png"
              alt="triangle"
            />
            <div className="home-header-themes-container">
              <ul className="home-header-featured-theme">
                {page &&
                  page.content.map((trend) => {
                    if (trend.id <= 2) {
                      return (
                        <li key={trend.id}>
                          <h1>{trend.mainSubject},</h1>
                        </li>
                      );
                    }
                  })}
              </ul>
              <ul className="home-header-theme">
                {page &&
                  page.content.map((trend) => {
                    if (trend.id > 2 && trend.id < 7) {
                      return (
                        <li key={trend.id}>
                          <h1>{trend.mainSubject} e</h1>
                        </li>
                      );
                    }
                  })}
              </ul>
              <ul className="home-header-theme">
                {page &&
                  page.content.map((trend) => {
                    if (trend.id > 6 && trend.id <= 10) {
                      return (
                        <li key={trend.id}>
                          <h1>{trend.mainSubject}</h1>
                        </li>
                      );
                    }
                  })}
              </ul>
              <ul className="home-header-edition">
                <li>
                  <h6>edição 06</h6>
                </li>
              </ul>
            </div>
            <img
              className="figure-waves"
              src="https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/header/waves.png"
              alt="waves"
            />
          </div>
          <img
            className="figure-rectangle"
            src="https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/header/rectangle_points.png"
            alt="rectangle-point"
          />
          <img
            className="figure-woman"
            src="https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/header/mulher.png"
            alt="mulher-card"
          />
        </div>
      </section>
    </header>
  );
};

export default Navbar;

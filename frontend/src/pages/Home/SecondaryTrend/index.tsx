import { Trend } from "../../../types/trend";

type Props = {
  trend: Trend;
};

const SecondaryTrend = ({ trend }: Props) => {
  return (
    <li>
      <div>
        <a target="_blank" rel="noopener" href={trend.sourceUrl}>
          <figure
            className={
              trend.imgsUrl.length === 2
                ? "home-trends-images"
                : "" || trend.imgsUrl.length === 4
                ? "home-trends-images"
                : ""
            }
            id={
              trend.imgsUrl.length === 2
                ? "animation-two-elements"
                : "" || trend.imgsUrl.length === 4
                ? "animation-for-elements"
                : ""
            }
          >
            {trend.imgsUrl.map((imgUrl) => (
              <img
                src={imgUrl.imgUrl}
                alt={trend.mainSubject}
                key={imgUrl.id}
              />
            ))}
          </figure>
          <h1>{trend.title}</h1>
        </a>
      </div>
      <div>
        <p>Fonte: {trend.source}</p>
        <div className="trends-card-time">
          <div className="trends-time-left"></div>
        </div>
      </div>
    </li>

    /*
        <li>
          <div>
            <a
              target="_blank"
              rel="noopener"
              href="https://www.uol.com.br/ecoa/reportagens-especiais/agua-em-lata-e-em-papelao-nova-garrafa-do-futuro-gera-corrida-sustentavel/"
            >
              <figure>
                <img
                  src="https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/content/agua_na_caixa.png"
                  alt="Zero Plástico"
                />
              </figure>
              <h1>'Garrafa do futuro' gera corrida sustentável.</h1>
            </a>
          </div>
          <div>
            <span>
              <p>Fonte: UOL</p>
            </span>
            <div className="trends-card-time">
              <div className="trends-time-left"></div>
            </div>
          </div>
        </li>

        <li>
          <div>
            <a
              target="_blank"
              rel="noopener"
              href="https://confrebras.org.br/agua-na-caixa-e-nova-tendencia-sustentavel/"
            >
              <figure>
                <img
                  src="https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/content/hope_in_box.png"
                  alt="Água na Caixa"
                />
              </figure>
              <h1>Água na caixa é nova tendência sustentável.</h1>
            </a>
          </div>
          <div>
            <span>
              <p>Fonte: CONFREBRAS 2021</p>
            </span>
            <div className="trends-card-time">
              <div className="trends-time-left"></div>
            </div>
          </div>
        </li>

        <li>
          <div>
            <a
              target="_blank"
              rel="noopener"
              href="https://marketing.twitter.com/pt/success-stories/virgin-mobile-australia-feeds-the-hungry-with-a-hashtag"
            >
              <figure>
                <img
                  src="https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/content/virgin_mobile_mealforameal.png"
                  alt="#mealforameal"
                />
              </figure>
              <h1>Empresa usa marketing para combater a fome.</h1>
            </a>
          </div>
          <div>
            <span>
              <p>Fonte: Marketing Twitter</p>
            </span>
            <div className="trends-card-time">
              <div className="trends-time-left"></div>
            </div>
          </div>
        </li>*/
  );
};

export default SecondaryTrend;

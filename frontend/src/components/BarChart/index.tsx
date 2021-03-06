import axios from "axios";
import { useEffect, useState } from "react";
import Chart from "react-apexcharts";
import { SaleSucess } from "types/sales";
import { round } from "utils/format";
import { BASEURL } from "utils/requests";
type SeriesData = {
  name: string;
  data: number[];
};
type ChartData = {
  labels: {
    categories: string[];
  };
  series: SeriesData[];
};

const BarChart = () => {
  const [chartData, setChartData] = useState<ChartData>({
    labels: { categories: [] },
    series: [
      {
        name: "",
        data: [],
      },
    ],
  });

  const options = {
    plotOptions: {
      bar: {
        horizontal: true,
      },
    },
  };

  useEffect(() => {
    axios.get(`${BASEURL}/sales/success-by-seller`).then((response) => {
      const data = response.data as SaleSucess[];
      const myLabels = data.map((x) => x.sellerName);
      const mySeries = data.map((x) => round((100.0 * x.deals) / x.visited, 1));

      setChartData({
        labels: { categories: myLabels },
        series: [
          {
            name: "% Sucesso",
            data: mySeries,
          },
        ],
      });
    });
  }, []);

  return (
    <Chart
      options={{ ...options, xaxis: chartData.labels }}
      series={chartData.series}
      type="bar"
      height="240"
    />
  );
};

export default BarChart;

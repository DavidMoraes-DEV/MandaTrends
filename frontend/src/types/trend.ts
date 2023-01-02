import { TrendImage } from "./trendImage"

export type Trend = {
    id: number,
    title: string,
    description: string,
    mainSubject: string,
    sourceUrl: string,
    source: string,
    imgsUrl: TrendImage[]
}

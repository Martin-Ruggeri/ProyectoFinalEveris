import { Base } from './base';
import { Star } from './star';

export class Planet extends Base{
    name:String;
    size:number;
    dTO_Star:Star;
}
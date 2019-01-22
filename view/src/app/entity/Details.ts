export class Details {
  id: number;
  private name: string;
  private x: string;
  private y: string;
  private count: string;
  private thickness: string;
  private material: string;
  private colorId: number;
  private edgeOnX: boolean;
  private edgeOnY: boolean;
  private edgeTypeY: string;
  private edgeTypeX: string;
  private edgeSideX: string;
  private edgeSideY:string;
  private edgeIdSideX: number;
  private edgeIdSideY: number;
  private moduleId: number;

  constructor(id: number, name: string, x: string, y: string, count: string, thickness: string, material:
    string, colorId: number, edgeOnX: boolean, edgeOnY: boolean, edgeTypeY: string, edgeTypeX: string, edgeSideX: string, edgeSideY: string, edgeIdSideX: number, edgeIdSideY: number, moduleId: number) {
    this.id = id;
    this.name = name;
    this.x = x;
    this.y = y;
    this.count = count;
    this.thickness = thickness;
    this.material = material;
    this.colorId = colorId;
    this.edgeOnX = edgeOnX;
    this.edgeOnY = edgeOnY;
    this.edgeTypeY = edgeTypeY;
    this.edgeTypeX = edgeTypeX;
    this.edgeSideX = edgeSideX;
    this.edgeSideY = edgeSideY;
    this.edgeIdSideX = edgeIdSideX;
    this.edgeIdSideY = edgeIdSideY;
    this.moduleId = moduleId;
  }
}

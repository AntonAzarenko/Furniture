import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material";

interface DialogCreateDetailData{
   name: string;
   x: string;
   y: string;
   count: string;
   thickness: string;
   material: string;
   edgesId: string;
   colorsId: string;
}

@Component({
  selector: 'app-detail-create-dialog',
  templateUrl: './detail-create-dialog.component.html',
  styleUrls: ['./detail-create-dialog.component.css']
})
export class DetailCreateDialogComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<DetailCreateDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: DialogCreateDetailData,
              ) {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit() {
  }

}

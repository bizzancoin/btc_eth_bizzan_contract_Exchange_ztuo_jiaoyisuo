//
//  KSGuaidViewController.h
//  KSGuaidViewDemo
//
//  Created by Mr.kong on 2019/5/24.
//  Copyright © 2019年 iCloudys. All rights reserved.
//

#import <UIKit/UIViewController.h>
#import <UIKit/UIScreen.h>
#import <UIKit/UIPageControl.h>
#import <UIKit/UIButton.h>
#import <UIKit/UICollectionViewFlowLayout.h>

@interface KSGuaidViewController : UIViewController

@property (nonatomic, copy) dispatch_block_t willDismissHandler;

@end

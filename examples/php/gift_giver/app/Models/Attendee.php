<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Attendee extends Model
{
    protected $fillable = [
        'name', 'vendor_member_id', 'awarded',
    ];

    protected $attributes = [
        'awarded' => false,
    ];

    public function scopeNotAwarded($query)
    {
        return $query->where('awarded', '=', 0);
    }

    public function scopeAwarded($query)
    {
        return $query->where('awarded', '=', 1);
    }
}
